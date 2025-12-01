package com.example.getitdone.data


class GIDRepository(private val dao: DoneDao) {
    val allTodo: kotlinx.coroutines.flow.Flow<List<GetItDone>> = dao.getAllToDo()

    suspend fun insert(todo: GetItDone) = dao.insert(todo)
    suspend fun update(todo: GetItDone) = dao.update(todo)
    suspend fun delete(todo: GetItDone) = dao.delete(todo)
}