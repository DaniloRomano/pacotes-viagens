import { userTypes, storageKeys } from '@/constants'

class UserService{
    getSelectedUser(){
        return localStorage.getItem(storageKeys.USER_KEY)
    }

    setUserCustomer(){
        localStorage.setItem(storageKeys.USER_KEY,userTypes.CUSTOMER)
    }

    setUserAdministrator(){
        localStorage.setItem(storageKeys.USER_KEY, userTypes.ADMINISTRATOR)
    }

    logoutUser(){
        localStorage.removeItem(storageKeys.USER_KEY)
    }
}

export default new UserService()