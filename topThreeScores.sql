select ID, NAME
from STUDENT
where SCORE in (select s.SCORE
                from STUDENT as s
                order by s.SCORE desc, s.ID asc
    limit 3
    )
order by SCORE desc, ID asc ;