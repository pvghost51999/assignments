--EXCERCISE 4
	--Create a function that takes as inputs a SalesOrderID, a Currency Code, and 
	--a date, and returns a table of all the SalesOrderDetail rows for that Sales Order including Quantity, ProductID, UnitPrice,
	--and the unit price converted to the target currency based on the end of day rate for the date provided.
	--Exchange rates can be found in the Sales.CurrencyRa
		select * from 
		Sales.CurrencyRate
		select *
		from
		sales.SalesOrderDetail

			GO
		CREATE FUNCTION dbo.ufnGenrateOrderDetails
			(
			@SalesOrderID INT,
			@CurrencyCode CHAR(3),
			@date DATE
			)
			RETURNS @t TABLE
			(
			ProductID INT,
			Quantity INT,
			UnitPrice FLOAT,
			ConvertedRate FLOAT
			)
			AS
			BEGIN
			DECLARE @rate AS INT
			SELECT @rate=EndOfDayRate
			FROM Sales.CurrencyRate
			WHERE ToCurrencyCode=@CurrencyCode AND ModifiedDate = @date

			INSERT INTO @t
			SELECT SalesOrderID,ProductID,UnitPrice,UnitPrice*@rate
			FROM Sales.SalesOrderDetail
			WHERE SalesOrderID= @SalesOrderID
			RETURN
			END
			GO

		SELECT*
		FROM dbo.ufnGenrateOrderDetails(43661,'JPY','2005-07-03 00:00:00.000')


	
