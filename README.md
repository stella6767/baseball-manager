
![image](https://user-images.githubusercontent.com/65489223/112576252-48c1bf80-8e35-11eb-9508-90acaa873b25.png)
![image](https://user-images.githubusercontent.com/65489223/112576261-4ceddd00-8e35-11eb-89d2-f06cdcfddbf9.png)
![image](https://user-images.githubusercontent.com/65489223/112576268-4fe8cd80-8e35-11eb-92f6-2ba909e60b86.png)
![image](https://user-images.githubusercontent.com/65489223/112576300-5bd48f80-8e35-11eb-8450-8e3dfc939df4.png)


LG, lotte, 삼성을 칼러명으로 주고, 
만약 teamid = lg 일 경우, name을 lg 아래에 둔다. 없으면 null 이고   



```
select
position, 
1 LG, 
2 LOTTE, 
3 SAMSUNG
from player;

select * from player;


# MAX = 뭐라도 있는 값을 가져와라.

# 피벗!!!!!!!!
select
position, 
MAX(if(teamid=1, name, "")) LG, 
MAX(if(teamid=2, name, "")) LOTTE, 
MAX(if(teamid=3, name, "")) SAMSUNG
from player group by position;
```


```
select p.position as 'position'  , 
GROUP_CONCAT((CASE WHEN p.teamId = 1 THEN p.name ELSE null END)) as '롯데' , 
GROUP_CONCAT((CASE WHEN p.teamId = 2 THEN p.name ELSE null END)) as 'NC', 
GROUP_CONCAT((CASE WHEN p.teamId = 3 THEN p.name ELSE null END)) as '기아',
GROUP_CONCAT((CASE WHEN p.teamId = 4 THEN p.name ELSE null END)) as '해태'
from player p GROUP BY p.position;


select position from player ;
SELECT MAX(CASE id WHEN 1 THEN value END)
    , MAX(CASE id WHEN 2 THEN value END)
    , MAX(CASE id WHEN 3 THEN value END)
FROM tbl_name;

```



