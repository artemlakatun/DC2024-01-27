package com.github.kornet_by.dc.lab4.repository.impl

import com.github.kornet_by.dc.lab4.bean.Issue
import com.github.kornet_by.dc.lab4.dao.IssueDao
import com.github.kornet_by.dc.lab4.repository.IssuesRepository

class IssuesRepositoryImpl(
	private val dao: IssueDao
) : IssuesRepository {
	override suspend fun create(item: Issue): Long? {
		return try {
			dao.create(item)
		} catch (_: Exception) {
			null
		}
	}

	override suspend fun deleteById(id: Long): Boolean = dao.deleteById(id) > 0

	override suspend fun getAll(): List<Issue?> = dao.getAll()

	override suspend fun getById(id: Long): Issue? {
		return try {
			dao.getById(id)
		} catch (_: Exception) {
			null
		}
	}

	override suspend fun update(item: Issue): Boolean = dao.update(item) > 0
}