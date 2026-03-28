
import axios from "axios";
import { tokenService } from "../services/tokenService";

const API_BASE_URL = "http://localhost:8080/api/users";

const adminApi = {

    // get all users
    getAllUsers() {
        return axios.get(API_BASE_URL, {
            headers: {
                Authorization: `Bearer ${tokenService.getAccessToken()}`
            }
        });
    },
    // activate user
    activateUser(userId) {
        return axios.put(`${API_BASE_URL}/${userId}/activate`, {}, {
            headers: {
                Authorization: `Bearer ${tokenService.getAccessToken()}`
            }
        });
    },
    // deactivate user(admin only)
    deactivateUser(userId) {
        return axios.put(`${API_BASE_URL}/${userId}/deactivate`, {}, {
            headers: {
                Authorization: `Bearer ${tokenService.getAccessToken()}`
            }
        });
    }
};

export default adminApi;