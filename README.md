# Automated Parking System

Welcome to the Automated Parking System! This project provides a simple and intuitive command-line interface for managing parking lots without the need for any external database support. Everything runs smoothly in memory!

## Commands:

1. **create_parking_lot \<number\>**  
   - Creates a new parking lot with the specified number of slots.
   - **Required**: \<number\> - The number of slots to create.
   - **Example**: `create_parking_lot 10` - Creates a parking lot with 10 slots.

2. **park \<car registration Number\> \<car color\>**  
   - Parks a car in the parking lot with the provided registration number and color.
   - **Required**: \<car registration Number\> - The registration number of the car.
   - **Required**: \<car color\> - The color of the car.
   - **Example**: `park KA-01-HH-1234 White` - Parks a white car with registration number KA-01-HH-1234.

3. **leave \<slot number\>**  
   - Vacates the parking slot corresponding to the given slot number.
   - **Required**: \<slot number\> - The slot number to vacate.
   - **Example**: `leave 3` - Vacates slot number 3.

4. **status**  
   - Displays the current status of all parked cars in the parking lot.
   - **Example**: `status` - Shows the status of all parked cars.

5. **registration_numbers_for_cars_with_color \<car color\>**  
   - Lists the registration numbers of all cars with the specified color.
   - **Required**: \<car color\> - The color of the cars to list.
   - **Example**: `registration_numbers_for_cars_with_color White` - Lists registration numbers of all white cars.

6. **slot_number_for_car_with_color \<car color\>**  
   - Retrieves the slot number of the car with the specified color.
   - **Required**: \<car color\> - The color of the car to retrieve the slot number for.
   - **Example**: `slot_number_for_car_with_color White` - Retrieves the slot number of a white car.

7. **slot_numbers_for_car_with_registration_numbers \<car registration_numbers\>**  
   - Fetches the slot numbers of cars with the provided registration numbers.
   - **Required**: \<car registration_numbers\> - The registration numbers of the cars.
   - **Example**: `slot_numbers_for_car_with_registration_numbers KA-01-HH-1234, KA-01-HH-9999` - Retrieves the slot numbers of cars with registration numbers KA-01-HH-1234 and KA-01-HH-9999.

8. **exit**  
   - Exits the application.