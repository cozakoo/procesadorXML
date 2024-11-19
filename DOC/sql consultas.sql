# Agrup por legajo y tipoiigg 

select DISTINCT l_mlega, c.tipoigg
, sum(l_dimp)
from ene24 s
left join concparam c
on s.l_dley = c.ley and s.l_dconc = c.conc
where s.l_dconc < 2700 and c.iigg = 1 --IS NULL
group by l_mlega,  c.tipoigg
order by 1




#detectar mas de un hijo declaradoa al 100 por mismos padres
select  a.nya,f.* from fliares as f
left join
agentes as a
on f.documento = a.documento
where docfam in (
select docfam from fliares
where porcen = 100
group by docfam
having count(documento) > 1 ) 
order by docfam