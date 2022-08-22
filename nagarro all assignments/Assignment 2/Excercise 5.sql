--EXERCISE 5
	--Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name.
	--Alter the above Store Procedure to supply Default Values if user does not enter any value
		--creating a procedure
			CREATE PROCEDURE spNameInf
			@Name varchar(50)
			AS
			BEGIN
			SELECT FirstName,MiddleName,LastName
			FROM Person.Person
			WHERE FirstName=@Name
			END
			GO



		--altering a procedure
			ALTER PROCEDURE spNameInf
			@Name varchar(50) = 'KEN'
			AS
			BEGIN
			SELECT FirstName,MiddleName,LastName
			FROM Person.Person
			WHERE FirstName=@Name
			END
			GO



	exec spNameInf