<cfcache action="put" id="susi" value="Susanne" timespan="#createtimespan(0,0,0,1)#">
<cfdump var="#cacheKeyExists('susi')#">
<cfset sleep(1500)>
<cfdump var="#cacheKeyExists('susi')#">
