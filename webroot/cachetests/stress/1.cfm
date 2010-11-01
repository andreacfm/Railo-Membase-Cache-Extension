<cfsetting requesttimeout="180">

<cffunction name="getObject" returntype="any">
	<cfreturn {key = arguments.value}>
</cffunction>

<cfset start = gettickcount()>
<cfloop from="1" to="1000" index="i">
	<cfcache action="put" id="#i#" value="#getObject(value = i)#">
	<cfcache action="get" id="#i#" name="v">
</cfloop>
<cfset end = gettickcount()>

<cfoutput>#end - start# millis</cfoutput>

<cfset cacheClear() >

<cfloop from="1" to="40" index="i">
	<cfhttp url="http://localhost:8888/cachetests/" result="res">
	<cfoutput> <br>- #res.status_code#</cfoutput>
	<cfflush>
</cfloop>
