--Excersise 6
	--Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. 
	--Modify the above trigger to execute its check code only if the ListPrice column is updated
		CREATE OR ALTER TRIGGER [Production].[LimitListPrice]
		ON Production.Product
		INSTEAD OF UPDATE
		AS
		SET NOCOUNT ON
		BEGIN
		IF UPDATE(ListPrice)
			DECLARE @OldListPrice money
			DECLARE @NewListPrice money
			DECLARE @ID int
			SELECT @OldListPrice = p.ListPrice,
			@NewListPrice=inserted.ListPrice,
			@ID = inserted.ProductID
			FROM Production.Product p, inserted
			WHERE p.ProductID = inserted.ProductID;

			IF( @NewListPrice > ( @OldListPrice + (0.15*@OldListPrice) ) )
				BEGIN
				RAISERROR('LIST PRICE MORE THAN 15 PERCENT, TRANSACTION FAILED',16,0)
				ROLLBACK TRANSACTION
				END
			ELSE
				BEGIN
				Update Production.Product SET ListPrice=@NewListPrice
				WHERE Production.Product.ProductID = @ID;
				END

		END;
		SELECT Production.Product.ProductID,
		Production.Product.ListPrice
		FROM PRODUCTION.Product;



--Will be executed successfully
	UPDATE PRODUCTION.Product
	SET ListPrice=14
	WHERE Product.ProductID=1;


-- Will gave an error message
	UPDATE PRODUCTION.Product
	SET ListPrice=133.34
	WHERE Product.ProductID=1;
