<cfset a = []>
<cfset ArrayAppend(a,"blahblah")>
<cfset ArrayAppend(a,"blahblah_blah")>
<cfset ArrayAppend(a,"blahblah_blahblah")>
 
<cfset cachePut("test_array",a,CreateTimeSpan(0,0,10,0),CreateTimeSpan(0,0,10,0))>
<cfset t = cacheGet("test_array")>
 
<cfdump var="#t#">
 
<cfset ArrayAppend(a,"blahblah_blahblah_blahblah")>
 
<cfset cachePut("test_array",a,CreateTimeSpan(0,0,10,0),CreateTimeSpan(0,0,10,0))>
<cfset t = cacheGet("test_array")>
 
<cfdump var="#t#">

