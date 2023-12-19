-- insert bedrooms
INSERT INTO bedroom(id_bedroom,hospital_sector,occupancy_status,capacity)VALUES(1,"Radiology",true,2);
INSERT INTO bedroom(id_bedroom,hospital_sector,occupancy_status,capacity)VALUES(2,"Pediatrics",false,3);
INSERT INTO bedroom(id_bedroom,hospital_sector,occupancy_status,capacity)VALUES(3,"Intensive Care",true,4);
INSERT INTO bedroom(id_bedroom,hospital_sector,occupancy_status,capacity)VALUES(4,"Gynecology",true,1);
INSERT INTO bedroom(id_bedroom,hospital_sector,occupancy_status,capacity)VALUES(5,"Surgery",true,1);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (1, 'Carlos', 'Sanchez', 1, '45120665', 19, 70.0, 1.70);
-- insert patients
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (2, 'Maria', 'Lopez', 2, '45120666', 25, 55.0, 1.60);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (3, 'John', 'Doe', 3, '45120667', 30, 80.0, 1.75);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (4, 'Laura', 'Smith', 3, '45120668', 22, 65.0, 1.68);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (5, 'Robert', 'Johnson', 5, '38120669', 28, 75.0, 1.80);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (6, 'Emily', 'Brown', 1, '29120670', 32, 60.0, 1.65);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (7, 'Daniel', 'Martinez', 2, '44120671', 20, 72.0, 1.78);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (8, 'Sophia', 'Garcia', 3, '35120672', 27, 68.0, 1.73);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (9, 'Ethan', 'Rodriguez', 4, '27120673', 35, 85.0, 1.85);
INSERT INTO patient(id_patient, name, last_name, id_bedroom, dni, age, weight, height) VALUES (10, 'Olivia', 'Perez', 3, '42120674', 24, 62.0, 1.67);
--insert medical specialty
INSERT INTO medical_specialty(title, description) VALUES ('Cardiology', 'Deals with heart-related issues');
INSERT INTO medical_specialty(title, description) VALUES ('Dermatology', 'Focuses on skin conditions');
INSERT INTO medical_specialty(title, description) VALUES ('Neurology', 'Specializes in the nervous system');
INSERT INTO medical_specialty(title, description) VALUES ('Orthopedics', 'Deals with musculoskeletal issues');
INSERT INTO medical_specialty(title, description) VALUES ('Pediatrics', 'Specializes in child health');
INSERT INTO medical_specialty(title, description) VALUES ('Ophthalmology', 'Focuses on eye care');
INSERT INTO medical_specialty(title, description) VALUES ('Oncology', 'Deals with cancer treatment');
INSERT INTO medical_specialty(title, description) VALUES ('Psychiatry', 'Focuses on mental health');
INSERT INTO medical_specialty(title, description) VALUES ('Urology', 'Specializes in the urinary system');
INSERT INTO medical_specialty(title, description) VALUES ('Gastroenterology', 'Deals with digestive system issues');
--insert doctors
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Anderson', 'Harris', 1); -- Cardiology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. White', 'Thompson', 2); -- Dermatology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Wilson', 'Martínez', 3); -- Neurology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Moore', 'González', 4); -- Orthopedics
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Taylor', 'López', 5); -- Pediatrics
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Jackson', 'Lee', 6); -- Ophthalmology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Davis', 'Johnson', 7); -- Oncology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Harris', 'Brown', 8); -- Psychiatry
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Baker', 'Rodríguez', 9); -- Urology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Miller', 'García', 10); -- Gastroenterology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Martin', 'Kim', 1); -- Cardiology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Anderson', 'Thompson', 2); -- Dermatology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Harris', 'Martínez', 3); -- Neurology
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. White', 'González', 4); -- Orthopedics
INSERT INTO doctor (name, last_name, id_medical_specialty) VALUES ('Dr. Wilson', 'López', 5); -- Pediatrics

-- Inserting medical records corresponding to specific patients with single string values for previous illnesses and current medication
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('Diabetes', 'Insulin', 1);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('Common Cold', 'Ibuprofen', 2);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('None', 'None', 3);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('Asthma', 'Albuterol', 4);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('Allergies', 'Claritin', 5);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('None', 'None', 6);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('Diabetes', 'Insulin', 7);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('Heart Disease', 'Aspirin', 8);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('None', 'None', 9);
INSERT INTO medical_record (previous_illness, current_medication, id_patient) VALUES ('None', 'None', 10);

-- Insert appointments
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-15', '10:00 AM', 1, 1);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-16', '02:30 PM', 2, 2);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-17', '09:15 AM', 3, 3);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-18', '11:00 AM', 4, 4);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-19', '03:45 PM', 5, 5);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-20', '01:30 PM', 6, 6);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-21', '10:45 AM', 7, 7);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-22', '04:20 PM', 8, 8);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-23', '12:15 PM', 9, 9);
INSERT INTO appointment (appointment_date, appointment_time, id_doctor, id_patient) VALUES ('2023-12-24', '08:30 AM', 10, 10);
