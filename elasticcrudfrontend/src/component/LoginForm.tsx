import UserService from "../service/UserService";
import { useNavigate } from "react-router-dom";
import {useState} from "react";


function LoginForm(){
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')
    const navigate = useNavigate();


    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const userData = await UserService.login(email, password)
            console.log(userData)
            if (userData.response.token) {
                localStorage.setItem('token', userData.response.token)
                localStorage.setItem('role', userData.response.role)
                console.log("below BookList")
                navigate('/book-list')
            }else{
                setError(userData.message)
            }

        } catch (error) {
            console.log(error)
            setError(error.message)
            setTimeout(()=>{
                setError('');
            }, 5000);
        }
    }


    return(
        <div className="auth-container">
            <h2>Login</h2>
            {error && <p className="error-message">{error}</p>}
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Email: </label>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                </div>
                <div className="form-group">
                    <label>Password: </label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <button type="submit">Login</button>
                <button type="submit">Dont have accout Register Here?</button>
            </form>
        </div>
    )

}

export default LoginForm;