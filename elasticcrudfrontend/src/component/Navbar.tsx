
import { Link } from 'react-router-dom';
import UserService from '../service/UserService';

function Navbar() {
    const isAuthenticated = UserService.isAuthenticated();

    const handleLogout = () => {
        const confirmDelete = window.confirm('Are you sure you want to logout this user?');
        if (confirmDelete) {
            UserService.logout();
        }
    };


    return (
        <nav>
            <ul>
                {!isAuthenticated && <li><Link to="/">Phegon Dev</Link></li>}
                {isAuthenticated && <li><Link to="/" onClick={handleLogout}>Logout</Link></li>}
            </ul>
        </nav>
    );
}

export default Navbar;