--EXCERCISE 3
	--Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks
		SELECT TOP 5 SalesOrderID
		FROM Sales.SalesOrderHeader
		WHERE AccountNumber IN 
		(
		SELECT AccountNumber
		FROM SALES.SalesOrderHeader

		GROUP BY AccountNumber
		HAVING SUM(TotalDue)>70000
		)
		ORDER BY OrderDate DESC

		SELECT*
		FROM Sales.SalesOrderHeader




	
