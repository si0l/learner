@REM run container
docker run --network employee-mysql --name learner -d -p 8080:8080 -p 8081:8081 psub/learner