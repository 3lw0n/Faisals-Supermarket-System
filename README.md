# Faisal's Supermarket Billing & Stock Management System

A robust console-based Java application designed to simulate a real-world supermarket point-of-sale (POS) and inventory control environment.

## 🚀 Key Features
* **Parallel Data Integrity:** Synchronized management of 30 product items, pricing arrays, and available stock indices.
* **Custom Exception Handling:** Secured transactional state using a custom `InvalidQuantity` exception to strictly block negative quantities or over-purchasing beyond current warehouse levels.
* **Advanced Algorithmic Logic:** Nested control loops separating multi-user session continuations from inner item filtering, text searches, and average price calculation routines.
* **Automated Billing and Discounts:** Built-in calculation tier applying programmatic 5% and 15% discount bounds natively on runtime orders.

## 💻 Technical Stack
* **Language:** Java (JDK 8 or higher)
* **Concepts Applied:** Custom Exceptions, Control Flow, Array Manipulation, Input Streams (`Scanner`).
