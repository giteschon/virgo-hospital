create database VirgoHospital
go
use VirgoHospital
go




--use master drop database VirgoHospital

--TABLES
create table [State]
(
IDState int primary key identity,
Name nvarchar(50)
)

create table City
(
IDCity int primary key identity,
Name nvarchar(50),
StateID int foreign key references [State](IDState)
)

--create table AddressType
--(
--IDAddressType int primary key identity,
--[Type] nvarchar(20)
--)

create table Pincode
(
IDPincode int primary key identity,
Value nvarchar(5),
CityID int foreign key references City(IDCity),
Area nvarchar(20) null
)

--KOMPLICIRANJE ADRESE, MOZEMO  SAMO STAVIT ADDRESS1, ADDRESS 2 I ONDA DA CITA STATE, CITY I PINCODE .. OVAK ZATRPAVAM BAZU

----ovo za pacijenta samo
--create table PermanentAddress
--(
--IDAddress int primary key identity,
--Street nvarchar(50),
--DoorNo nvarchar(4),
--PincodeID int foreign key references  Pincode(IDPincode),
----AddressTypeID int foreign key references AddressType(IDAddressType)
--)


create table [Address]
(
IDAddress int primary key identity,
Street nvarchar(50),
DoorNo nvarchar(4),
PincodeID int foreign key references  Pincode(IDPincode),
)


create table ContactType
(
IDContactType int primary key identity,
[Type] nvarchar(20)
)



create table Relationship
(
IDRelationship int primary key identity,
[Name] nvarchar(50)
)



create table MaritalStatus
(
IDMaritalStatus int primary key identity,
[Status] nvarchar(25)
)

create table Occupation
(
IDOccupation int primary key identity,
Occupation nvarchar(25)
)


--mozda bi bilo jednostavnije da je sve u jednoj tablici, ali ne znam ovo mi se cini ko bolje rjesenje
create table Contact
(
--fali telefon, mail. ...
IDContact int primary key identity,
ContactDetail nvarchar(50),
ContactTypeID int foreign key references ContactType(IDContactType),
--to nije dobro jer nemam osobu, nego doktore i pacijente, tako bi mozda bilo bolje imat tablicu osobakontakt u kojoj ce svi bit
--PersonID int foreign key references Patient(IDPatient) null,
--NextofKinID int foreign key references NextOfKin(IDNextOfKin) null
)

create table MedicalPersonnel
(
IDPersonnel int primary key identity,
FirstName nvarchar(20),
MiddleName nvarchar(20),
Surname nvarchar(20),
AddressID int foreign key references [Address](IDAddress),
ContactID int foreign key references Contact(IDContact),
PersonnelOccupationID int foreign key references Occupation(IDOccupation)
)

--create table Profession
--(
--IDProffesion int primary key identity,
--Profession nvarchar(20)
--)

--imamo doktore i medicinsko osoblje da manje podataka vuce iz baze, tj. da manje vrti
--sve stavit u osoblje

create table Doctor
(
IDPersonnel int primary key identity,
FirstName nvarchar(20),
MiddleName nvarchar(20),
Surname nvarchar(20),
AddressID int foreign key references [Address](IDAddress),
ContactID int foreign key references Contact(IDContact),
--bool yes/no odnosno 1 ili 0
Available bit
)

create table Sex
(
IDSex int primary key identity,
Sex nvarchar(10)
)

create table BloodTypeRh
(
IDBloodRh int primary key identity,
[Type] nvarchar(3)
)

create table NextOfKin
(
IDNextOfKin int primary key identity,
FirstName nvarchar(20),
MiddleName nvarchar(20),
Surname nvarchar(20),
AddressID int foreign key references [Address](IDAddress),
RelationshipID int foreign key references Relationship(IDRelationship),
ContactID int foreign key references Contact(IDContact)
)

create table Patient
(
IDPatient int primary key identity,
FirstName nvarchar(20),
MiddleName nvarchar(20),
Surname nvarchar(20),
SexID int foreign key references Sex(IDSex),
DateOfBirth date,
PresentAddressID int foreign key references [Address](IDAddress) null,
PermanentAddressID int foreign key references [Address](IDAddress) null,
ContactID int foreign key references Contact(IDContact),
NextofKinID int foreign key references NextOfKin(IDNextOfKin),
MaritalStatusID int foreign key references MaritalStatus(IDMaritalStatus),
--broj ljudi koje uzdrzava
NoOfDependents int,
Height int,
[Weight] int,
BloodTypeRhID int foreign key references BloodTypeRh(IDBloodRh),
OccupationID int foreign key references Occupation(IDOccupation),
GrossAnnualIncome money,
Vegetarian bit,
Smoker bit,
NoCigarettesADay int,
ConsumesAlcohol bit,
NoDrinksADay int,
Stimulants nvarchar(500),
CoffeeTeaDay int,
SoftDrinksDay int,
RegularMeals nvarchar(500),
HomeFood bit,
StatementOfComplaint nvarchar(500),
PreviousTreatments nvarchar(500),
PhysicianHospitalTreated nvarchar(100),
Diabetic nvarchar(200),
Hypertensive nvarchar(200),
CardiacCondition nvarchar(200),
RespiratoryCondition nvarchar(200),
DigestiveCondition nvarchar(200),
OrthopedicCondtion nvarchar(200),
MuscularCondition nvarchar(200),
KnownAllergies nvarchar(500),
KnownReactionToSpecificDrug nvarchar(500),
MajorSurgeriesHistory nvarchar(1000),
EntryTime date
)



--create table PatientNextofKin
--(
--PatientID int foreign key references Patient(IDPatient),
--NextofKinID int foreign key references NextOfKin(IDNextOfKin)
--)

--hmm ali moram imat adresu na na osobu jer imam 2 adrese ....





--BILLING
create table PaymentMethod
(
IDPaymentMethod int primary key identity,
Payment nvarchar(20)
)

create table Invoice
(
IDInvoice int primary key identity,
InvoiceNumber nvarchar(10),
PatientID int foreign key references Patient(IDPatient),
PaymentMethodID int foreign key references PaymentMethod(IDPaymentMethod),
--sum ukupno koliko treba platit cijeli racun, detalji kolko je kaj se vidi na stavkama- tj. specka racuna
InvoiceSum money,
InvoiceDate date
)

create table Medicine
(
IDMedicine int primary key identity,
Name nvarchar(50),
Price money
)

create table Test
(
IDTest int primary key identity,
[Type] nvarchar(50),
Price money
)

create table Consultation
(
IDConsultation int primary key identity,
Name nvarchar(200),
Price money
)

--treba mi nesto ko stavka, internet kaze item
create table Item
(
IDItem int primary key identity,
InvoiceID int foreign key references Invoice(IDInvoice),
MedicineID int foreign key references Medicine(IDMedicine) null,
TestID int foreign key references Test(IDTest) null,
ConsultationID int foreign key references Consultation(IDConsultation) null,
PatientId int foreign key references Patient(IDPatient),
EntryDate date

--ili samo stavit 25 posto i kasnije mnozit, ne znam
)


--ne treba na stavci fee kad je cijena na testu ili cemu vec, tam bi ustvari trebalo stavit pdv, ali to je tak nebitno za sad

--fali appointment history

create table FutureAppointment
(
IDFutureAppointment int primary key identity,
PatientID int foreign key references Patient(IDPatient),
DoctorID int foreign key references Doctor(IDPersonnel),
[Date] date
)

create table MedicalHistory
(
IDMedicalHistory int primary key identity,
Diagnosis nvarchar(500),
TestID int foreign key references Test(IDTest) null,
TestuResult nvarchar(100),
MedicineID int foreign key references Medicine(IDMedicine) null,
MedicinePrescription nvarchar(100),
FollowupAppointment bit
)

go
--DATA
--insert into AddressType values
--('Permanent'),
--('Present')

insert into ContactType values
('Work Telephone'),
('Home Telephone'),
('Mobile'),
('Pager'),
('Fax'),
('Email')

insert into Relationship values
('Brother'),
('Sister'),
('Mother'),
('Father'),
('Son'),
('Daughter'),
('Grandfather'),
('Grandmother'),
('Aunt'),
('Uncle'),
('Nephew'),
('Niece'),
('Husband'),
('Wife'),
('Daughter-in-law'),
('Son-in-law'),
('Mother-in-law'),
('Father-in-law'),
('Cousin')

insert into MaritalStatus values
('Single'),
('In a relationship'),
('Engaged'),
('Married'),
('Divorced'),
('Widowed')

insert into Occupation values
('Nurse'),
('Doctor'),
('Surgeon'),
('Support staff'),
('Lawyer'),
('Progammer'),
('Designer'),
('Accountant'),
('Physician'),
('Cardiac suregon'),
('Neurologist'),
('Medical doctor'),
('Dermatologist')

--insert into Profession values
--('Physician'),
--('Cardiac suregon'),
--('Neurologist'),
--('Medical doctor'),
--('Dermatologist')

insert into Sex values
('Male'),
('Female'),
('Other')

insert into PaymentMethod values
('Cash'),
('Credit card')

insert into Medicine values
('Vipidia', 56.79),
('Victoza', 111.15),
('Neofen', 30),
('None',0)

insert into Test values
('PET scan', 2000),
('EEG', 150),
('Biopsy', 500.39),
('none',0)

insert into Consultation values
('General medical examination', 200),
('General consultation', 50),
('none',0)

insert into BloodTypeRh values
('0+'),
('0-'),
('A+'),
('A-'),
('B+'),
('B-'),
('AB+'),
('AB-')

insert into State values
('Croatia'),
('Germany')

insert into City values
('Zagreb',1),
('Varaždin',1),
('Rijeka',1),
('Berlin',2)

--mozda adresa ipak ne treba svoju tablicu nego samo svoju klasu jer ce to bi titsuce rezultata tako da mislim da je to nepotrebno

insert into Pincode values
('10000',1,'Zagreb'),
('10020',1, 'Novi Zagreb'),
('42000',2, null),
('51000',3,null),
('10115',4,'Mitte')








--DUMMY DATA

--insert into NextOfKin values



--PROCEDURES

--CRUD

--ADD
--DOCTOR
go
create proc addDoctor
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@AddressID int,
@ContactID int,
--@ProfessionID int,
@Availble bit
as
	insert into Doctor (FirstName, MiddleName, Surname, AddressID, ContactID, Available)  values 
	(@FirstName, @MiddleName, @Surname,@AddressID, @ContactID,@Availble)

go
create proc editDoctor
@id int,
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@AddressID int,
@ContactID int,
--@ProfessionID int,
@Availble bit
as
update Doctor set
FirstName=@FirstName,
MiddleName=@MiddleName,
Surname=@Surname,
AddressID=@AddressID,
ContactID=@ContactID,
Available=@Availble
where IDPersonnel=@id

go

create proc getDoctor
@id int
as 
select * from Doctor
where IDPersonnel=@id
go

create proc getDoctors
as 
select * from Doctor
go

--NEXT OF KIN
create proc addNextOfKin
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@AddressID int,
@RelationshipID int,
@ContactID int
--@id int out
as
begin
	insert into NextOfKin (FirstName, MiddleName, Surname, AddressID, RelationshipID, ContactID) values
	(@Firstname, @MiddleName, @Surname,@AddressID,@RelationshipID,@ContactID)
	--set @id=SCOPE_IDENTITY()
end
go

create proc addEmergencyNextOfKin
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@RelationshipID int
as
begin
	insert into NextOfKin (FirstName, MiddleName, Surname, RelationshipID) values
	(@Firstname, @MiddleName, @Surname,@RelationshipID)
	
end
go

create proc editNextOfKin
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@AddressID int,
@RelationshipID int,
@ContactID int,
@id int
as
update NextOfKin set
FirstName=@FirstName,
MiddleName=@MiddleName,
Surname=@Surname,
AddressID=@AddressID,
RelationshipID=@RelationshipID,
ContactID=@ContactID
where IDNextOfKin=@id
go

create proc getNextOfKin
@id int
as
select * from NextOfKin
where IDNextOfKin=@id

go
create proc getNextOfKins
as
select * from NextOfKin
go

create proc getNextOfKinO
@name nvarchar(20),
@surname nvarchar(20)
as
select * from NextOfKin
where FirstName=@name and Surname=@surname
go

--MEDICAL PERSONNEL
create proc addMedicalPersonnel
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@AddressID int,
@ContactID int,
@PersonnelOccupationID int
--@id int out
as
begin
	insert into MedicalPersonnel (FirstName, MiddleName, Surname, AddressID, ContactID, PersonnelOccupationID) values
	(@Firstname, @MiddleName, @Surname, @AddressID,@ContactID, @PersonnelOccupationID)
	--set @id=SCOPE_IDENTITY()
end
go

create proc editMedicalPersonnel
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@AddressID int,
@ContactID int,
@PersonnelOccupationID int,
@id int
as
update MedicalPersonnel set
FirstName=@FirstName,
MiddleName=@MiddleName,
Surname=@Surname,
AddressID=@AddressID,
ContactID=@ContactID,
PersonnelOccupationID=@PersonnelOccupationID
where IDPersonnel=@id
go

create proc getMedicalPersonnel
@id int
as
select * from MedicalPersonnel
where IDPersonnel=@id
go

create proc getMedicalPersonnels
as
select * from MedicalPersonnel

go


--PATIENT
create proc addEmergencyPatient
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@SexID int, 
@DateofBirth date,
@ContactID int,
@NextofKinID int,
@statement nvarchar(500)
as
	begin
	insert into Patient(FirstName, MiddleName, Surname, SexID, DateOfBirth,ContactID,NextofKinID,StatementOfComplaint,EntryTime) values
	(@Firstname, @MiddleName, @Surname,@SexID, @DateOfBirth,@ContactID,@NextofKinID,@statement,CONVERT(date, getdate()))
	--set @idPatient=SCOPE_IDENTITY()
	--insert into NextOfKin(FirstName, MiddleName, Surname,PatientID,RelationshipID) values
	--(@NoKFirstName, @NoKMiddleName, @NoKSurname, @idpatient, @RelationshipID)
	--insert into Contact(ContactDetail,ContactTypeID, PersonID) values
	--(@HomeTelephone,2, @idPatient),
	--(@Mobile, 3,@idPatient)
	end
go

create proc addPatient
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@SexID int, 
@DateofBirth date,
@PresentAddressID int,
@PermanentAddressID int,
@ContactID int,
@NextofKinID int,
@MaritalStatusID int,
@NoOfDependents int,
@Height int,
@Weight int,
@BloodTypeRhID int,
@OccupationID int,
@GrossAnnualIncome money,
@Vegetarian bit,
@Smoker bit,
@NoCigarettesADay int, 
@ConsumesAlcohol bit, 
@NoDrinksADay int, 
@Stimulants nvarchar(50), 
@CoffeeTeaDay int, 
@SoftDrinksDay int, 
@RegularMeals nvarchar(500), 
@HomeFood bit, 
@StatementOfComplaint nvarchar(500), 
@PreviousTreatments nvarchar(500), 
@PhysicianHospitalTreated nvarchar(100), 
@Diabetic nvarchar(200), 
@Hypertensive nvarchar(200), 
@CardiacCondition nvarchar(200), 
@RespiratoryCondition nvarchar(200), 
@DigestiveCondition nvarchar(200), 
@OrthopedicCondtion nvarchar(200), 
@MuscularCondition nvarchar(200), 
@KnownAllergies nvarchar(500), 
@KnownReactionToSpecificDrug nvarchar(500), 
@MajorSurgeriesHistory nvarchar(1000)
as
insert into Patient (FirstName, MiddleName, Surname, SexID, DateOfBirth, PresentAddressID, PermanentAddressID, ContactID, NextofKinID, MaritalStatusID, NoOfDependents, Height, Weight, BloodTypeRhID, OccupationID, GrossAnnualIncome, Vegetarian, Smoker, NoCigarettesADay, ConsumesAlcohol, NoDrinksADay, Stimulants, CoffeeTeaDay, SoftDrinksDay, RegularMeals, HomeFood, StatementOfComplaint, PreviousTreatments, PhysicianHospitalTreated, Diabetic, Hypertensive, CardiacCondition, RespiratoryCondition, DigestiveCondition, OrthopedicCondtion, MuscularCondition, KnownAllergies, KnownReactionToSpecificDrug, MajorSurgeriesHistory,EntryTime) values
(@FirstName, @MiddleName, @Surname, @SexID, @DateOfBirth, @PresentAddressID, @PermanentAddressID, @ContactID, @NextofKinID, @MaritalStatusID, @NoOfDependents, @Height, @Weight, @BloodTypeRhID, @OccupationID, @GrossAnnualIncome, @Vegetarian, @Smoker, @NoCigarettesADay, @ConsumesAlcohol, @NoDrinksADay, @Stimulants, @CoffeeTeaDay, @SoftDrinksDay, @RegularMeals, @HomeFood, @StatementOfComplaint, @PreviousTreatments, @PhysicianHospitalTreated, @Diabetic, @Hypertensive, @CardiacCondition, @RespiratoryCondition, @DigestiveCondition, @OrthopedicCondtion, @MuscularCondition, @KnownAllergies, @KnownReactionToSpecificDrug, @MajorSurgeriesHistory,CONVERT(date, getdate()))

go

create proc editPatient
@FirstName nvarchar(20),
@MiddleName nvarchar(20),
@Surname nvarchar(20),
@SexID int, 
@DateofBirth date,
@PresentAddressID int,
@PermanentAddressID int,
@ContactID int,
@NextofKinID int,
@MaritalStatusID int,
@NoOfDependents int,
@Height int,
@Weight int,
@BloodTypeRhID int,
@OccupationID int,
@GrossAnnualIncome money,
@Vegetarian bit,
@Smoker bit,
@NoCigarettesADay int, 
@ConsumesAlcohol bit, 
@NoDrinksADay int, 
@Stimulants nvarchar(50), 
@CoffeeTeaDay int, 
@SoftDrinksDay int, 
@RegularMeals nvarchar(500), 
@HomeFood bit, 
@StatementOfComplaint nvarchar(500), 
@PreviousTreatments nvarchar(500), 
@PhysicianHospitalTreated nvarchar(100), 
@Diabetic nvarchar(200), 
@Hypertensive nvarchar(200), 
@CardiacCondition nvarchar(200), 
@RespiratoryCondition nvarchar(200), 
@DigestiveCondition nvarchar(200), 
@OrthopedicCondtion nvarchar(200), 
@MuscularCondition nvarchar(200), 
@KnownAllergies nvarchar(500), 
@KnownReactionToSpecificDrug nvarchar(500), 
@MajorSurgeriesHistory nvarchar(1000),
@id int
as
update Patient set
FirstName=@FirstName,
MiddleName=@MiddleName,
Surname=@Surname,
SexID=@SexID,
DateOfBirth=@DateofBirth,
PresentAddressID=@PresentAddressID,
PermanentAddressID=@PermanentAddressID,
ContactID=@ContactID,
NextofKinID=@NextofKinID,
MaritalStatusID=@MaritalStatusID,
NoOfDependents=@NoOfDependents,
Height=@Height,
[Weight]=@Weight,
BloodTypeRhID=@BloodTypeRhID,
OccupationID=@OccupationID,
GrossAnnualIncome=@GrossAnnualIncome,
Vegetarian=@Vegetarian,
Smoker=@Smoker,
NoCigarettesADay=@NoCigarettesADay,
ConsumesAlcohol=@ConsumesAlcohol,
NoDrinksADay=@NoDrinksADay,
Stimulants=@Stimulants,
CoffeeTeaDay=@CoffeeTeaDay,
SoftDrinksDay=@SoftDrinksDay,
RegularMeals=@RegularMeals,
HomeFood=@HomeFood,
StatementOfComplaint=@StatementOfComplaint,
PreviousTreatments=@PreviousTreatments,
PhysicianHospitalTreated=@PhysicianHospitalTreated,
Diabetic=@Diabetic,
Hypertensive=@Hypertensive,
CardiacCondition=@CardiacCondition,
DigestiveCondition=@DigestiveCondition,
OrthopedicCondtion=@OrthopedicCondtion,
MuscularCondition=@MuscularCondition,
KnownAllergies=@KnownAllergies,
KnownReactionToSpecificDrug=@KnownReactionToSpecificDrug,
MajorSurgeriesHistory=@MajorSurgeriesHistory
where IDPatient=@id

go
create proc getPatient
@id int
as
select * from Patient
where IDPatient=@id

go
create proc getPatients
as
select * from Patient
go


--EDIT
--DELETE
--GET

--get patient
--get patients
--get dotor
--get doctors


--FORM DATA PROCS
--sex
go
create proc getSexes
as
select * from Sex

go
create proc getSex
@id int
as
select * from Sex
where IDSex=@id

--blood type
go
create proc getBloodTypes
as
select * from BloodTypeRh

go
create proc getBloodType
@id int
as
select * from BloodTypeRh
where IDBloodRh=@id

--payment type
go
create proc getPaymentTypes
as
select * from PaymentMethod

go
create proc getPaymentType
@id int
as
select * from PaymentMethod
where IDPaymentMethod=@id

--zenskica na salteru prvo stavlja sve kaj oce na racun i onda joj se zgenerira i tad ce bit i broj
--invoice
go
create proc addInvoice
--@IDinvoice int out,
@patientID int,
@paymentID int
as
declare @id int
begin
	insert into Invoice(PatientID, PaymentMethodID, InvoiceDate) values
	(@patientID, @paymentID,CONVERT(date, getdate()))
	set @id=SCOPE_IDENTITY()
	--set @IDinvoice=SCOPE_IDENTITY()
	--set @invoiceNo=@IDinvoice + '1-1'
	update Invoice set
InvoiceNumber=convert(nvarchar(20),@id) + '/1/2018' where IDInvoice=@id

end

go
create proc addInvoiceSum
@sum money,
@id int
as
update Invoice set
InvoiceSum=@sum
where IDInvoice=@id

--id nam treba kak bi se kao mogo printat odnosno spremat
go
create proc getInvoice
@IDinvoice int
as
select * from Invoice
where IDInvoice=@IDinvoice
go
--treba tu i stavku stavit

--address
create proc addAddress
@Street nvarchar(50),
@DoorNo nvarchar(5),
@PincodeId int
as
insert into [Address] values
(@Street,@DoorNo,@PincodeId)
go

create proc editAddress
@Street nvarchar(50),
@DoorNo nvarchar(5),
@PincodeId int,
@id int
as
update [Address] set
Street=@Street,
DoorNo=@DoorNo,
PincodeID=@PincodeId
where IDAddress=@id
go

create proc getAddress
@id int
as
select * from [Address]
where IDAddress=@id
go

create proc getAddressO
@street nvarchar(50),
@doorNo nvarchar(4),
@pincodeId int
as
select * from [Address]
where Street=@street and DoorNo=@doorNo and PincodeID=@pincodeId
go

--contact
create proc addContact
@ContactDetail nvarchar(50),
@ContactType int
as
insert into Contact values
(@ContactDetail,@ContactType)
go

create proc editContact
@ContactDetail nvarchar(50),
@ContactTypeID int,
@id int
as
update Contact set
ContactDetail=@ContactDetail,
ContactTypeID=@ContactTypeID
where IDContact=@id
go

create proc getContact
@id int
as
select * from Contact
where IDContact=@id
go

--contacttype
create proc getContactType
@id int
as 
select * from ContactType
where IDContactType=@id
go

create proc getContactTypes
as
select * from ContactType
go

create proc getContactO
@details nvarchar(50)
as
select * from Contact
where ContactDetail=@details
go

--pincode
create proc getPincode
@id int
as
select * from Pincode
where IDPincode=@id
go

create proc getPincodes
as
select * from Pincode
go

--city
create proc getCity
@id int
as
select * from City
where IDCity=@id
go

create proc getCities
as
select * from City
go

--state
create proc getState
@id int
as
select * from State
where IDState=@id
go

create proc getStates
as
select * from State
go

--occupation
create proc getOccupation
@id int
as
select * from Occupation
where IDOccupation=@id
go

create proc getOccupations
as
select * from Occupation
go

--relatinoship
create proc getRelationship
@id int
as
select * from Relationship
where IDRelationship=@id
go

create proc getRelationships
as
select * from Relationship
go

--marital status
create proc getMaritalStatus
@id int
as
select * from MaritalStatus
where IDMaritalStatus=@id
go

create proc getMaritalStatuses
as
select * from MaritalStatus
go

--medicine
go
create proc getMedicines
as
select * from Medicine

--get medicine
go
create proc getMedicine
@idMedicine int
as
select * from Medicine
where IDMedicine=@idMedicine

--test
go
create proc getTests
as
select * from Test

go
create proc getTest
@idTest int
as 
select * from Test
where IDTest=@idTest

--consultation
go
create proc getConsultations
as
select * from Consultation

go
create proc getConsultation
@id int
as
select * from Consultation
where IDConsultation=@id

--items
go
create proc getItemsPerInvoice
@idInvoice int
as
select * from Item
where InvoiceID=@idInvoice

go
create proc addItemTest
@invoiceId int,
@testId int
as

insert into Item(InvoiceID, TestID) values
(@invoiceId, @testId)

go
create proc addItemConsultation
@invoiceId int,
@consultationId int
as

insert into Item(InvoiceID, ConsultationID) values
(@invoiceId, @consultationId)

go
create proc addItemMedicine
@invoiceId int,
@medicineId int
as

insert into Item(InvoiceID, MedicineID) values
(@invoiceId, @medicineId)
--pacijente cemo trazit po id-u jer bi to trebalo pisat na papiru s kojim idu na salter za placanje ... tako da cemo pojednostavit max

go
create proc getInvoiceO
@date date,
@patientId int
as
select * from Invoice
where PatientID=@patientId and InvoiceDate=@date
go


create table DoctorPatient
(
IDDoctorPatient int primary key identity,
DoctorID int foreign key references Doctor(IDPersonnel),
PatientID int foreign key references Patient(IDPatient),
DateOfTreatment date
)

go

--REPORT PROCS

--create proc getDoctorPatient
--@idDoctor int,
--@idPatient int
create proc getPatientsPerDoctor
@idDoctor int
as
select * from DoctorPatient
where DoctorID=@idDoctor
go

go
create proc getNoOfPatientsSeenByVariousDoctors
@date date
as
select * from DoctorPatient
where DateOfTreatment=@date
go

go
create proc getNoOfFollowUpPatients
@date date
as
select  count(*) from DoctorPatient as dp
inner join Patient as p
on p.IDPatient=dp.PatientID
where dp.DateOfTreatment=@date and p.EntryTime != @date
go

create proc getNoOfFollowUpPatientsForPeriod
@date date,
@dateStart date,
@dateEnd date
as
select  count(*) from DoctorPatient as dp
inner join Patient as p
on p.IDPatient=dp.PatientID
where (dp.DateOfTreatment between @dateStart and @dateEnd) and p.EntryTime != dp.DateOfTreatment
go

create proc getAvgnumberOfPatientPerDoctor
@dateStart date,
@dateEnd date
as
select DoctorID, COUNT(PatientID)
from DoctorPatient
where DateOfTreatment between @dateStart and @dateEnd
group by DoctorID

go

--no of new patients for daily report
create proc getNoOfNewPatients
@date date
as
select count(*) from Patient
where EntryTime=@date

go

--no of new patients  for monthly or weekly  report
create proc getNoOfNewPatientsForPeriod
@dateStart date,
@dateEnd date
as
select count(*) from Patient
where EntryTime between  @dateStart and @dateEnd
go

create proc itemsSummaryForPatient
@idPatient int,
@date date
as
select count(ConsultationID),count(TestID), count(MedicineID) from Item
where EntryDate=@date and PatientID=@idPatient
go

create proc getNoOfPatientsTreatedByDoctor
@idDoctor int,
@dateStart date,
@dateEnd date
as
select count(*) from DoctorPatient
where DoctorID=@idDoctor and (DateOfTreatment between @dateStart and @dateEnd)

go

create proc getPatientO
@firstName nvarchar(20),
@surname nvarchar(20)
as
select * from Patient
where FirstName=@firstName and Surname=@surname
go

create proc addItem
@medicineID int,
@testID int,
@consultationID int,
@patientID int
as
insert into Item(MedicineID, TestID, ConsultationID, PatientId, EntryDate) values
(@medicineID, @testID,@consultationID,@patientID, CONVERT(date, getdate()))
go

create proc getItemsPerPatient
@idPatient int
as
select * from Item as i
where i.PatientId=@idPatient 
go


--create proc deletePatient
--@id int
--as
--declare
--@idAddress1 int,
--@idAddress2 int

--set @idAddress1=(select IDAddress from Patient as p
--inner join Address as a
--on p.PresentAddressID=a.IDAddress
--where IDPatient=@id)
--set @idAddress2=(select IDAddress from Patient as p
--inner join Address as a
--on p.PermanentAddressID=a.IDAddress
--where IDPatient=@id)

--delete Item where PatientId=@id
--delete Patient where IDPatient=@id
--delete Address where IDAddress=@idAddress1
--delete Address where IDAddress=@idAddress2

create proc deleteMedicalPersonnel
@id int
as
declare @idContact int,
@idAddress int
--set @idContact=(select c.IDContact from MedicalPersonnel as mp
--inner join Contact as c
--on c.IDContact=mp.ContactID
--where mp.IDPersonnel=@id)

set @idAddress=(select a.IDAddress
 from MedicalPersonnel as mp
inner join Address as a
on a.IDAddress=mp.AddressID
where mp.IDPersonnel=@id)

delete MedicalPersonnel where IDPersonnel=@id
--delete Address where IDAddress=@idAddress
--delete Contact where IDContact=@idContact
go

create proc deleteDoctor
@id int
as
delete Doctor where IDPersonnel=@id
go

go
create proc addFutureAppointemnt
@idPatient int,
@idDoctor int,
@date date
as
insert into FutureAppointment values
(@idPatient,@idDoctor,@date)
go

create proc getDoctorsForPatient
@idPatient int
as
select * from DoctorPatient where PatientID=@idPatient
go

create proc addDoctorPatient
@idDoctor int,
@idPatient int
as
insert into DoctorPatient values
(@idDoctor,@idPatient,CONVERT(date, getdate()))
go

--exec getNoOfNewPatientsForPeriod '2019-01-31','2019-02-01'
--exec deleteDoctor 2

select * from Contact
select * from ContactType
select * from NextOfKin
select * from Patient

select * from Address
select * from MedicalPersonnel
select * from Doctor

select * from Pincode

select * from Item
select * from Invoice

--exec deletePatient 32
--exec deleteMedicalPersonnel 5

select * from FutureAppointment
select * from DoctorPatient

select * from Doctor






