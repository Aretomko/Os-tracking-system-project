
 <#import "parts/common.ftl" as c>

 <@c.page>
     <h1>All users</h1>
             <table id="tablePreview" class="table table-striped">
             <!--Table head-->
               <thead>
                 <tr>
                   <th>User</th>
                   <th>Cpu number</th>
                   <th>Used in percents</th>
                   <th>DisksInfo</th>
                   <th>Virtual memory total</th>
                   <th>Virtual memory in use</th>
                   <th>Open ports</th>
                 </tr>
               </thead>
               <tbody>
               <#list users as user>
                 <tr>
                     <td>${user.username}</td>
                     <td>${user.getCpu().getCpuNumber()}</td>
                     <td>${user.getCpu().getUsedInPercents()}</td>
                     <td><a href="/seeDiskInfo/${user.id}">See info</a></td>
                     <td>${user.getVirtualMemory().getTotal()}</td>
                     <td>${user.getVirtualMemory().getInUse()}</td>
                     <td><a href="/seeOpenPorts/${user.id
                     }">See open ports</a></td>
                 </tr>
               </#list>
               </tbody>
             </table>
 </@c.page>