create table consultas(
                  id int not null auto_increment,
                  medico_id int not null,
                  paciente_id int not null unique,
                  data datetime not null ,

                  primary key(id),
                  constraint fk_consulta_medico_id foreign key(medico_id) references medicos(id),
                  constraint fk_consulta_paciente_id foreign key(paciente_id) references medicos(id)


);