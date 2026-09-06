home server

# hobby tracker



192.168.178.116



paths:

* /home
* /start/\_
* /end
* 
* /api
* /api/status
* /api/stats
* 
* /new\_routine
* /add\_period # manually add past time periods
* /edit/\_
* /





## /home : GET

display some of the statistics on a pretty html packed page

buttons to:

* /start/\_  OR /end
* /new\_hobby
* /add\_period
* /edit/\_
* 



layout includes:

general stats of some recent history

last 4 weeks calendar

list of most importnat hobbies

\-> with opton to edit/delete

(show all hobbies)



\## /start/\_ ## POST?

start a new hobby time period of \_ id

(just a simple GET or POST) no return needed i think



\## /end ## : POST?

ends current running time period if any are running

same with /start, no additional html site



\## /api ## : redirect to ---



under /api path will be pages that for given GET return jsons



\## /api/status ## : GET



return simple json of running periods (can be empty)



\## /api/stats/\_ ## : GET



return a jason with all the data from the \_ last days



\## /new\_routine ## : POST?

(doesnt have to be a spearate page, can be rendered on the home or idk)

new routine creation

* select color



\## /new\_period ## : POST?

(doesnt have to be a spearate page, can be rendered on the home or idk)

new period creation

* selct routine
* selct start, end time



\## /edit/\_ ## : POST?

(doesnt have to be a spearate page, can be rendered on the home or idk)

edits already existing period of time under the period id of \_



just sends the corrected json of the period

