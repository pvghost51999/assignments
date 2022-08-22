--Excersise 2
	--Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed an order.
		--using join
		select CustomerId
		from sales.Customer
		where CustomerID
		not in(
		select c.CustomerID
		from sales.Customer c
		inner join
		sales.SalesOrderHeader s
		on c.CustomerID=s.CustomerID
		)

		--using subquery
		select CustomerID
		from sales.Customer c
		where CustomerID NOT in
		(
		select distinct(CustomerID)
		from Sales.SalesOrderHeader
		)

		--using CTE
		WITH Nosale (CustomerID)
		as
		(
		SELECT distinct(CustomerID)
		FROM Sales.SalesOrderHeader

		)

		SELECT CustomerID
		from Sales.Customer
		where CustomerID NOT IN
		(
		SELECT *
		FROM Nosale
		)

		--using EXISTS
		SELECT CustomerID
		FROM Sales.Customer C
		WHERE EXISTS
		(
			select CustomerID
			from sales.Customer c
			where CustomerID NOT in
			(
			select distinct(CustomerID)
			from Sales.SalesOrderHeader
			)
		)
		AND PersonID IS NULL

