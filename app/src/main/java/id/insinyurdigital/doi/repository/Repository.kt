package id.insinyurdigital.doi.repository

import id.insinyurdigital.doi.domain.DataState
import id.insinyurdigital.doi.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow

interface Repository {
//    suspend fun getProducts(): Flow<DataState<List<Product>>>
//    suspend fun getProductDetail(id: Int): Flow<DataState<Product>>
//    suspend fun getTransactions(): Flow<DataState<List<Order>>>
//    suspend fun getTransactionDetail(id: Int): Flow<DataState<OrderDetail>>
    suspend fun postLogin(username: String, password: String): Flow<DataState<UserDetail>>
//    suspend fun getMemberAddresses(idMember: String): Flow<DataState<List<MemberAddress>>>
//    suspend fun postCart(cartRequest: CartRequest): Flow<DataState<Cart>>
//    suspend fun getCarts(idMember: String): Flow<DataState<List<Cart>>>
//    suspend fun putCart(id: Int, cart: CartRequest): Flow<DataState<List<Cart>>>
//    suspend fun deleteCart(id: Int): Flow<DataState<List<Cart>>>
//    suspend fun postShipmentCourier(courierShipmentRequest: CourierShipmentRequest): Flow<DataState<List<Courier>>>
//    suspend fun postConvertCartToOrder(convert: ConvertCartOrderRequest): Flow<DataState<String>>
//    suspend fun getMemberOrders(idMember: String): Flow<DataState<List<Orders>>>
}