--Excercise 1
		--query 1
			--Display the number of records in the [SalesPerson] table
				SELECT count(*)
				FROM Sales.SalesPerson;

		--query 2
			--Select both the FirstName and LastName of records from the Person table where 
			--the FirstName begins with the letter ‘B’. (Schema(s) involved: Person)
				SELECT FirstName,LastName
				FROM Person.Person
				WHERE FirstName LIKE 'B%';
		
		--query 3
			--Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing Assistant.
			--(Schema(s) involved: HumanResources, Person)
				SELECT pp.FirstName,pp.LastName
				FROM Person.Person pp
				INNER JOIN
				HumanResources.Employee he
				ON pp.BusinessEntityID=he.BusinessEntityID
				WHERE jobTitle IN('Design Engineer','Senior Tool Designer','Marketing Assistant')

		--query 4
			--Display the Name and Color of the Product with the maximum weight.
				SELECT Name,Color
				FROM Production.Product
				WHERE Weight In
				(
				SELECT max(Weight)
				FROM Production.Product
				)
		-- query 5
			--Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL,
			--in this case display the value 0.00 instead. (Schema(s) involved: Sales)
				SELECT Description, ISNULL(MaxQty,0)
				FROM Sales.SpecialOffer

		--query 6
			--Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’
			--for the year 2005 i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined
			--as 'Average exchange rate for the day.' (Schema(s) involved: Sales)
				SELECT avg(AverageRate) as 'Average exchange rate for the day',year(2005) as Year
				FROM Sales.CurrencyRate
				WHERE FromCurrencyCode='USD' AND ToCurrencyCode='GBP'

		--query 7
			--Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. 
			--Display an additional column with sequential numbers for each row returned beginning at integer 1. 
				SELECT ROW_NUMBER() OVER(ORDER BY Title) AS 'sequential numbers' ,FirstName,LastName
				FROM Person.Person
				WHERE FirstName like '%ss%'

		--query 8
			--Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating
				SELECT BusinessEntityID as 'SalesPersonID' ,
				CASE
				WHEN CommissionPct=0 THEN 'Band 0'
				WHEN CommissionPct>0 and CommissionPct<=1.5 Then 'Band 1'
				WHEN CommissionPct>1.5 THEN 'Band 2'
				END as 'Commission Band'
				FROM Sales.SalesPerson

		-- query 9
			--Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) 
			--up to CEO Ken Sanchez. 
				DECLARE @id AS INT;
				SELECT @id=BusinessEntityID
				FROM Person.Person
				WHERE FirstName='Ruth' and LastName='Ellerbrock' and PersonType='EM'
				EXEC dbo.uspGetEmployeeManagers @id;

		--query 10
			--Display the ProductId of the product with the largest stock level
				DECLARE @val as INT
				select @val=ProductID
				from Production.Product
				where SafetyStockLevel In
				(
				SELECT max(SafetyStockLevel)
				FROM Production.Product
				)
				SELECT dbo.ufnGetStock(@val) as [LargestStock]

