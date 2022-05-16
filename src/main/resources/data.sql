insert into hardware values(1,  '385-C-P-U', 'CPU Name', 100.25, 'CPU', 5);
insert into hardware values(2, '385-STORAGE', 'STORAGE Name', 500.75, 'STORAGE', 10);
insert into hardware values(3,  '123-RAM-.i89','RAM Name', 320.0, 'RAM', 7);

insert into review values(1, 1, 'First review', 'This is a first review', 'two_stars');
insert into review values(2, 1, 'Second review', 'This is a second review', 'five_stars');
insert into review values(3, 2, 'Third review', 'This is a third review', 'three_stars');
insert into review values(4, 3, 'Fourth review', 'This is a fourth review', 'three_stars');
insert into review values(5, 3, 'Fifth review', 'This is a fifth review', 'four_stars');
insert into review values(6, 3, 'Sixth review', 'This is a sixth review', 'one_star');


insert into user(id, username, password)
values
    (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin


insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');


insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1);