# HA, Zones and Regions 

The Eureka Server does not have a backend store, but the service instances in the registry all 
have to send heartbeats to keep their registrations up to date (so this can be done in memory). 
Clients also have an in-memory cache of eureka registrations (so they don't have to go the 
registry for every single request to a service)

Be default every Eureka Server is a also a Eureka Client and requires (at least one) service URL 
to locate a peer.

# Standalone Mode

The combination of the two caches (client and server) and the heartbeats make a standalone 
`Eureka Server` fairly resilient to failure, as long as there is some sort of monitor or elastic 
runtime keeping it alive. In standalone mode, you might prefer to switch off the client side 
behaviour, so it doesn't keep trying and failint to reach its peers.
