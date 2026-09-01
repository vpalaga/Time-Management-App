
# hobby tracker

keep track of your time ... 


### paths:

```
* /home
* /start/_
* /end
* 
* /api
* /api/status
* /api/stats
* 
* /new_routine
* /add_period # manually add past time periods
* /edit/_
* /
```
 --- 

## /home : GET

display some of the statistics on a pretty HTML packed page

buttons to:

* /start/_  OR /end
* /new_hobby
* /add_period
* /edit/_
* 



layout includes:

general stats of some recent history

last 4 weeks calendar

list of most important hobbies

→ with option to edit/delete

(show all hobbies)



## /start/_  POST?

start a new hobby time period of _ id

(just a simple GET or POST) no return needed I think



## /end : POST?

ends current running time period if any are running

same with /start, no additional HTML site



## /api : redirect to ---



under /api path will be pages that for given GET return JSONs



## /api/status : GET



return simple JSON of running periods (can be empty)



## /api/stats/_ : GET



return a JSON with all the data from the _ last days



## /new_routine : POST?

(doesn't have to be a separate page, can be rendered on the home or IDK)

new routine creation

* select color



## /new_period : POST?

(doesn't have to be a separate page, can be rendered on the home or IDK)

new period creation

* select routine
* select start, end time



## /edit/_ : POST?

(doesn't have to be a separate page, can be rendered on the home or IDK)

edits already existing period of time under the period id of _



just sends the corrected JSON of the period



