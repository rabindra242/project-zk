import { useState } from "react";
import axios from "axios";

function BookList() {
    const [name, setName] = useState("");
    const [author, setAuthor] = useState("");
    const [books, setBooks] = useState([]);
    const [error, setError] = useState(null);

    const handleSearch = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/books/get-by-name-author", {
                params: {
                    name: name,
                    author: author
                }
            });
            setBooks(response.data.response);
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
                <button onClick={handleSearch}>Search</button>
            </div>
            {error && <div>{error}</div>}
            <h1>Books List</h1>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <div>Name: {book.name}</div>
                        <div>Author: {book.author}</div>
                        <div>ID: {book.id}</div>
                        <div>Price:{book.price}</div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default BookList;
