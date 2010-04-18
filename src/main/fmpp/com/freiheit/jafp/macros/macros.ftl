<#macro seplist range sep="">
<#list range as x><#if x != range?first>${sep}</#if><#nested x></#list></#macro>
<#macro csv range><@seplist range=range sep=", "; x><#nested x></@seplist></#macro>
