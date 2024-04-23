import {useState} from "react";
import BookList from "./BookList.tsx";

export default function MainFile(){
    const [showbook,setShowbook] = useState(false)

    return <div>
        <h1>Hello SpringBoot user</h1>
        <button onClick={()=>setShowbook(!showbook)} >
        Show Books
        </button>
        {showbook?
                <BookList/>
            : ""}
    </div>
}