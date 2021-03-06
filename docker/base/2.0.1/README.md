# Base image for all Sirma Enterprise Systems docker images

This image provides the main entry point for assigning user permissions and contains useful scripts.

Creates a dedicated user **dockeru** that will obtain ownership of all:
* volumes
* services
* scripts placed in /docker-init.d

## Useful scripts
### replace-env.sh - Replacing environment variables inside files 

Example usage: `replace-env.sh file1.conf file2.xml`

When invoked, this script will be executed for every line in the provided files.

The script supports replacing environment variables only in the following format: `${VARIABLE}`
(In other words - uppercase variable in single curly brackets starting with a dollar sign.)

The script will preserve any non binded variables.

### wait-for-service.sh - Wait for specific service to become reachable

Example usage: `wait-for-service.sh -h localhost -p 5432 -t 5 -m 10`

Command summary
    -h, --host - the service hostname
    -p, --port - the service port
    -t, --timeout - the timeout in seconds between tries
    -m, --max-tries - the maximum tries to reach the service


This script uses netcat internally.

## Built in user
The container comes with a user called `dockeru` which is used to run the actual service.
The user's UID and GID are `1000` by default, but they can be changed by setting the `DOCKER_USER_ID` and `DOCKER_USER_GROUP_ID` environment variables.
__NOTE__: if you change the UID or GID - you must manually change ownership of any volues.