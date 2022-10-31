<h1> ZIP code lookup service</h1>

Before building or running this app you must first ensure you have a local version of the Redis database running.

Ensure you have docker engine/desktop running. 

Then from your terminal run
<code> cd redis-database</code>

Once you are inside the redis directory run
<code>docker compose up</code>

Once Redis is up and running, you may build or run the app. If you simply want to run the app using docker go back up a directory and run that app. 
 
If you want to use the redis-cli to view the data in the data use  
<code>docker run -it  --network redis_default --rm redis redis-cli -h redis-redis-1</code>
(or whatever the network or container names are)

To fetch all the ZIP codes in the database using the cli run
<code>keys *</code>

To fetch a particular ZIP code entry run:
<code>json.get com.jbc.zipcodelookup.ZipCode:[zip code]</code>
