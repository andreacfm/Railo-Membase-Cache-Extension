<cfset server.enableCache=true>

<cflock scope="server" timeout="10">
	<cfset cacheName="membaseCache">
	<cfset cacheClear()>
	<cfset start = getTickCount()>
	<cfset cachePut('abc','_cachePut',CreateTimeSpan(0,0,0,1))>
	<cfset cachePut('def','_cachePut',CreateTimeSpan(0,0,0,2),CreateTimeSpan(0,0,0,1))>
	<cfset cachePut('ghi','_cachePut',CreateTimeSpan(0,0,0,0),CreateTimeSpan(0,0,0,0))>
    
    <cfset a=cacheGet('abc')>
    <cfset b=cacheGet('def')>
    <cfset c=cacheGet('ghi')>

    <cf_valueEquals left="#structKeyExists(variables,'a')#" right="true">
    <cf_valueEquals left="#structKeyExists(variables,'b')#" right="true">
    <cf_valueEquals left="#structKeyExists(variables,'c')#" right="true">
	
	

    <cfset sleep(2000)>
    <cfset d=cacheGet('abc')>
    <cfset e=cacheGet('def')>
    <cfset f=cacheGet('ghi')>
    <cf_valueEquals left="#structKeyExists(variables,'d')#" right="false">
    <cf_valueEquals left="#structKeyExists(variables,'e')#" right="false">
    <cf_valueEquals left="#structKeyExists(variables,'f')#" right="true">
    
    
    <cfset a = []>
	<cfset ArrayAppend(a,"one")>
	<cfset cachePut("test_array",a,CreateTimeSpan(0,0,10,0),CreateTimeSpan(0,0,10,0))>
	<cfset one = cacheGet("test_array")>
	<cf_valueEquals left="#arraylen(one)#" right="1">
	
	<cfset ArrayAppend(a,"two")>
	<cfset cachePut("test_array",a,CreateTimeSpan(0,0,10,0),CreateTimeSpan(0,0,10,0))>
	<cfset two = cacheGet("test_array")>
	<cf_valueEquals left="#arraylen(two)#" right="2">

    
    
<cfif server.ColdFusion.ProductName EQ "railo">    
	<cfset cachePut('def','123',CreateTimeSpan(0,0,0,2),CreateTimeSpan(0,0,0,1),cacheName)>
</cfif>
</cflock>

