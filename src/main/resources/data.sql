INSERT INTO Organization (org_id, name, full_name, address, phone, active, inn, kpp)
VALUES (null, 'Garprom', 'PAO Gagprom','Moskow, Tvertskaya, 15', '8(495)123-12-12', 1,
3456723456, 345675432); 

INSERT INTO Organization (org_id, name, full_name, address, phone, active, inn, kpp)
VALUES (null, 'Sberbank', 'PAO Sberbank','Moskow, Arbat, 158', '8(495)323-52-52', 1,
3456723445, 345675445); 


INSERT INTO Office (office_id, name, address, phone, active, org_id)
VALUES (null, 'Central NN', 'Gagarina, 15', '8(831)423-12-12', 1, 1);

INSERT INTO Office (office_id, name, address, phone, active, org_id)
VALUES (null, 'North branch NN', 'Akimova, 132', '8(831)432-34-43', 1, 1);

INSERT INTO Office (office_id, name, address, phone, active, org_id)
VALUES (null, 'Main NN', 'Larina, 15', '8(831)423-34-12', 1, 2);

INSERT INTO Office (office_id, name, address, phone, active, org_id)
VALUES (null, 'East branch NN', 'Radionova, 215', '8(831)423-42-22', 1, 2);


INSERT INTO User (user_id, first_name, second_name, middle_name, phone, position, identified, 
doc_number, doc_date, office_id, doc_id, country_id)
VALUES (null, 'Ivan', 'Petrov', 'Petrovich', '8(831)411-12-22', 'manager', 1, 22102345, '2010-10-15', 1, 7, 1);

INSERT INTO User (user_id, first_name, second_name, middle_name, phone, position, identified, 
doc_number, doc_date, office_id, doc_id, country_id)
VALUES (null, 'Oleg', 'Ivanov', 'Ivanovich', '8(831)412-22-23', 'manager', 1, 23145345, '2011-01-22', 1, 7, 1);

INSERT INTO User (user_id, first_name, second_name, middle_name, phone, position, identified, 
doc_number, doc_date, office_id, doc_id, country_id)
VALUES (null, 'Aleks', 'Luzhko', 'Sergeevich', '8(831)421-42-71', 'manager', 1, 22102375, '2009-11-02', 2, 4, 2);

INSERT INTO User (user_id, first_name, second_name, middle_name, phone, position, identified, 
doc_number, doc_date, office_id, doc_id, country_id)
VALUES (null, 'Rovshan', 'Bekov', 'Zikovich', '8(831)431-32-32', 'manager', 1, 22678945, '2012-06-11', 2, 4, 4);