import psutil
import time
import multiprocessing
import socket
from pip._vendor import requests

headers = {'Content-type': 'application/json'} # heder used in all requests


def get_memory_info():
    mem = psutil.virtual_memory()

    def bytes_to_gb(amount):
        return round(amount / 1e+9, 2)

    data = {
        "total": str(bytes_to_gb(mem.total)),
        "inUse": str(bytes_to_gb(mem.used))
    }

    return str(data).replace("\'", "\"")


def get_cpu_info():
    data = {
        "cpuNumber": str(multiprocessing.cpu_count()),
        "usedInPercents": str(int(psutil.cpu_percent()))
    }
    return str(data).replace("\'", "\"")


def get_disks_info():
    par = psutil.disk_partitions()
    # getting all of the disk partitions
    disks = []
    for x in par:
        dsk = psutil.disk_usage(x.mountpoint)
        disk = {
            "name": str(x.device),
            "total": str(dsk.total),
            "used": str(dsk.used),
            "usedInPercents": str(int(dsk.percent))
        }
        disks.append(disk)
    return "{\"disks\":" + str(disks).replace("\'", "\"") + "}"


def get_ports():
    ports = []
    lc = psutil.net_connections('inet')
    for c in lc:
        (ip, port) = c.laddr
        if ip == '0.0.0.0' or ip == '::':
            if c.type == socket.SOCK_STREAM and c.status == psutil.CONN_LISTEN:
                proto_s = 'tcp'
            elif c.type == socket.SOCK_DGRAM:
                proto_s = 'udp'
            else:
                continue
            pid_s = str(c.pid) if c.pid else '(unknown)'
            ports.append(port)

    return "{ \"ports\": \"" + str(ports).replace(" ", "").replace("[", "").replace("]", "") + "\"}"


def authenticate():
    username = input('Enter your username:')
    password = input('Enter your password')
    url = "http://localhost:8081/checkUserCredentials/"+username+"/"+password
    response = requests.get(url)  # check user credentials
    print(response)
    if response.status_code == 202:
        execute()
    else:
        authenticate()

def execute():
        while 1 == 1:
        # update indo about virtual memory
            url = "http://localhost:8081/setVirtualMemory/100"
            response = requests.post(url, data=get_memory_info(), headers=headers)  # update virtual memory info on server
            print(response)
            print("virtual info update")
            # update info about CPU
            url = "http://localhost:8081/setCPUInfoMemory/100"
            response = requests.post(url, data=get_cpu_info(), headers=headers)  # update virtual memory info on server
            print(response)
            print("cpu info update")
            url = "http://localhost:8081/setDiskInfo/100"
            response = requests.post(url, data=get_disks_info(), headers=headers)  # update disk information
            print(response)
            print("disk info update")
            url = "http://localhost:8081/setOpenPorts/100"
            response = requests.post(url, data=get_ports(), headers=headers)  # update open ports
            print(response)
            print("open ports update")
            time.sleep(10)


authenticate()
