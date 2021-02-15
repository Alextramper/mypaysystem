# mypaysystem
Веб-приложение типа платежной системы. 

Функциональное особенности, “Платежные операции”

Controller: JDBC - DAO - Servlet
Виды платежных операций:

	Оплата: таблица pay_data (id, client_id, target_account, sum, date)
	Перевод: таблица client_transfer_data (id, client_id, target_client_id, sum, date)
	Вывод: таблица client_withdrawal(id, client_id, sum, date)
  
  
