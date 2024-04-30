import axios from "axios";
class UserService {
    static BASE_URL = "http://localhost:8080";

    static async login(email, password) {
        return axios.post(`${UserService.BASE_URL}/auth/login`, { email, password })
            .then(response => response.data)
            .catch(err => { throw err; });
    }

    static async register(userData, token) {
        return axios.post(`${UserService.BASE_URL}/auth/register`, userData, {
            headers: { Authorization: `Bearer ${token}` }
        }).then(response => response.data)
            .catch(err => { throw err; });
    }

    /**AUTHENTICATION CHECKER */
    static logout() {
        localStorage.removeItem('token');
        localStorage.removeItem('role');
    }

    static isAuthenticated() {
        const token = localStorage.getItem('token');
        return !!token;
    }

    // static isAdmin() {
    //     const role = localStorage.getItem('role');
    //     return role === 'ADMIN';
    // }

    // static isUser() {
    //     const role = localStorage.getItem('role');
    //     return role === 'USER';
    // }
    //
    // static adminOnly() {
    //     return this.isAuthenticated() && this.isAdmin();
    // }
}

export default UserService;
