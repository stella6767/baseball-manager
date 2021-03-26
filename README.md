


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



