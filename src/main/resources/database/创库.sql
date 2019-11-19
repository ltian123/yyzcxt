
create temporary tablespace tsoa_temp  
 
tempfile 'C:\oracle\tsoa_temp.dbf' 
 
size 50m  
 
autoextend on  
 
next 50m maxsize 20480m  
 
extent management local;  


create tablespace tsoa
 
logging  
 
datafile 'C:\oracle\tsoa.dbf' 
 
size 50m  
 
autoextend on  
 
next 50m maxsize 20480m  
 
extent management local; 


create user tsoa identified by tsoa  
 
default tablespace tsoa  
 
temporary tablespace tsoa_temp;  


grant connect,resource,dba to tsoa;

