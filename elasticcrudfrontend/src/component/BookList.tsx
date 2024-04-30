import React, { useState, useEffect } from 'react';

function BookList(props) {
    const [name, setName] = useState("");
    const [author, setAuthor] = useState("");
    const [books, setBooks] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        // Fetch books data using token from localStorage
        fetchBooks();
    }, []);

    const fetchBooks = async () => {
        try {
            const token = localStorage.getItem('token'); // Retrieve the token from localStorage

            const response = await fetch(`http://localhost:8080/api/books/get-by-name-author?name=${name}&author=${author}`, {
                headers: {
                    Authorization: `Bearer ${token}` // Include the token in the Authorization header
                },
                redirect: "follow"
            });

            if (!response.ok) {
                throw new Error('Failed to fetch books');
            }

            // Check if the response is redirected
            if (response.redirected) {
                // Redirect to the URL provided in the response
                window.location.href = response.url;
                return;
            }

            const data = await response.json();
            setBooks(data.response);
        } catch (error) {
            setError("Error fetching books: " + error.message);
        }
    };

    return (
        <div>
            <h1>Search Books</h1>
            <div>
                <input type="text" placeholder="Enter book name" value={name} onChange={(e) => setName(e.target.value)} />
                <input type="text" placeholder="Enter author name" value={author} onChange={(e) => setAuthor(e.target.value)} />
                <button onClick={fetchBooks}>Search</button>
            </div>
            {error && <div>{error}</div>}
            <h1>Books List</h1>
            <ul>
                {books?.map(book => (
                    <li key={book.id}>
                        <div>Name: {book.name}</div>
                        <div>Author: {book.author}</div>
                        <div>ID: {book.id}</div>
                        <div>Price: {book.price}</div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default BookList;
