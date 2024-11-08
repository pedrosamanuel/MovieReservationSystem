# Movie Reservation System

A system that allows users to reserve movie tickets. It supports features like user authentication, movie and showtime management, seat reservation, and reporting on reservations.

## Features
- **User Authentication & Authorization**: Sign-up, log-in, and role-based access (admin and regular user).
- **Movie Management**: Admins can manage movies, including adding, updating, and deleting them.
- **Showtime Management**: Admins can create and manage movie showtimes.
- **Seat Reservation**: Users can reserve seats for available showtimes and view or cancel their reservations.
- **Reporting**: Admins can view all reservations, capacity, and revenue.

## Endpoints

### Showtime Management
- **GET** `/api/showtime/{id}`: Get a specific showtime by ID.
- **POST** `/api/showtime`: Create a new showtime (Admin).
- **GET** `/api/showtime/by-date`: Get showtimes for a specific date.
- **PUT** `/api/showtime/{id}`: Update a showtime (Admin).
- **DELETE** `/api/showtime/{id}`: Delete a showtime (Admin).

### Room Management
- **GET** `/api/room/{id}`: Get room details by ID.
- **POST** `/api/room`: Create a new room (Admin).
- **PUT** `/api/room/{id}`: Update room details (Admin).
- **DELETE** `/api/room/{id}`: Delete a room (Admin).

### Reservation Management
- **GET** `/api/reserve/{id}`: Get reservation details by ID.
- **POST** `/api/reserve`: Create a reservation (User).
- **PUT** `/api/reserve/{id}`: Update a reservation (User).
- **PUT** `/api/reserve/cancel/{reserveId}`: Cancel a reservation (User).
- **GET** `/api/reserve/user`: Get a list of reservations for the logged-in user.
- **GET** `/api/reserve/showtime/{showtimeId}`: Get available seats for a specific showtime.

### Movie Management
- **GET** `/api/movie/{id}`: Get movie details by ID.
- **POST** `/api/movie`: Create a new movie (Admin).
- **PUT** `/api/movie/{id}`: Update movie details (Admin).
- **DELETE** `/api/movie/{id}`: Delete a movie (Admin).

### Genre Management
- **GET** `/api/genre/{id}`: Get genre details by ID.
- **POST** `/api/genre`: Create a new genre (Admin).
- **PUT** `/api/genre/{id}`: Update genre details (Admin).
- **DELETE** `/api/genre/{id}`: Delete a genre (Admin).

### Seat Management
- **POST** `/api/seat`: Add a new seat (Admin).
- **GET** `/api/seat/showtime/{showtimeId}`: Get available seats for a specific showtime.
- **GET** `/api/seat/room/{roomId}`: Get available seats for a specific room.
- **DELETE** `/api/seat/{id}`: Delete a seat (Admin).

### Authentication
- **POST** `/api/auth/signup`: User registration.
- **POST** `/api/auth/signin`: User login.

## Key Considerations
- **Avoid Overbooking**: The system must handle seat reservation and prevent double bookings.
- **Scheduling**: Manage showtimes efficiently and ensure availability for each movie.
- **Reporting**: Admins should have access to detailed reports on reservations, capacity, and revenue.
- **User Roles**: Ensure correct authorization for admins and regular users.

## Database Models
- **User**: Stores information about users, including roles (admin or regular user).
- **Movie**: Stores movie details like title, description, and genre.
- **Showtime**: Stores information about specific movie showtimes, including dates and times.
- **Room**: Details of the rooms where movies are shown, including seating capacity.
- **Reservation**: Stores reservation details, including which user reserved which seats for a specific showtime.
- **Seat**: Represents individual seats in a room and tracks availability.

## Running the Project
1. Clone this repository.
2. Set up your backend environment.
3. Run the application (e.g., `java -jar movie-reservation-system.jar`).
4. Use the provided endpoints to interact with the system.

## Technologies
- Spring Boot
- JPA/Hibernate
- PostgreSQL (or other relational databases)
- JWT for user authentication

## Contribution
Feel free to submit pull requests for improvements or bug fixes. If you want to help with specific features, open an issue and mention what you'd like to work on!
