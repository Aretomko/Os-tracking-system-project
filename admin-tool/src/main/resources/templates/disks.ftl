
 <#import "parts/common.ftl" as c>

 <@c.page>
     <h1>Disks of ${username }</h1>
             <table id="tablePreview" class="table table-striped">
             <!--Table head-->
               <thead>
                 <tr>
                   <th>Disk name</th>
                   <th>Total memory mount</th>
                   <th>Used memory amount</th>
                   <th>Used in percents</th>
                 </tr>
               </thead>
               <tbody>
               <#list disks as disk>
                 <tr>
                     <td>${disk.name}</td>
                     <td>${disk.total}</td>
                     <td>${disk.used}</td>
                     <td>${disk.usedInPercents}</td>
                 </tr>
               </#list>
               </tbody>
             </table>
 </@c.page>