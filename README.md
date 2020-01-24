### Trouble shooting

#### 1. POSTGRESQL Database 접근 시, 유저 문제

1. Docker 를 이용한 POSTGRES 설치 시, 아래와 같이 컨테이너를 실행시킨다.
 
```bash
docker run -p 5432:5432 -e POSTGRES_PASSWORD=12345678 -e POSTGRES_USER=martin -e POSTGRES_DB=springdata --name postgres_boot -d postgres
```

2. 실행된 컨테이너를 터미널로 접속한다.

```bash
docker exec -i -t postgres_boot bash
```

3. 문제는 이 다음부터 이다. 아래와 같이 테이블에 접속하면 에러가 발생하는 것을 확인 할 수 있다.

```bash
su - postgres

psql springdata
# psql: error: could not connect to server: FATAL:  role "postgres" does not exist
```

그렇기 때문에 테이블에 접근할 때 다음과 같이 실행시켜줘야 한다.

```bash
su - postgres

psql --username martin --dbname springdata
# psql: error: could not connect to server: FATAL:  role "postgres" does not exist
```