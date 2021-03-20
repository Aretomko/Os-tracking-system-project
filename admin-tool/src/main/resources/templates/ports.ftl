
 <#import "parts/common.ftl" as c>

 <@c.page>
     <h1>Open ports of ${username}</h1>
             <table id="tablePreview" class="table table-striped">
             <!--Table head-->
               <thead>
                 <tr>
                   <th>Open port</th>
                   <th>Number</th>
                 </tr>
               </thead>
               <tbody>
               <#list ports as port>
                 <tr>
                     <td>+</td>
                     <td>${port}</td>
                 </tr>
               </#list>
               </tbody>
             </table>
 </@c.page>