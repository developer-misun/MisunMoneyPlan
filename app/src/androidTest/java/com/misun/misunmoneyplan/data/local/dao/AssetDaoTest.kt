package com.misun.misunmoneyplan.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.misun.misunmoneyplan.data.local.AssetDatabase
import com.misun.misunmoneyplan.data.local.entity.AssetEntity
import com.misun.misunmoneyplan.domain.model.AssetType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssetDaoTest {

    private lateinit var database: AssetDatabase
    private lateinit var assetDao: AssetDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AssetDatabase::class.java
        ).allowMainThreadQueries().build()
        assetDao = database.assetDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAndGetAllAssets() = runBlocking {
        val asset = AssetEntity("1", "Samsung", 50000, AssetType.STOCK, System.currentTimeMillis(), "Memo")
        assetDao.insertAsset(asset)

        val allAssets = assetDao.getAllAssets().first()
        assertEquals(1, allAssets.size)
        assertEquals(asset, allAssets[0])
    }

    @Test
    fun getAssetById() = runBlocking {
        val asset = AssetEntity("1", "Samsung", 50000, AssetType.STOCK, System.currentTimeMillis(), "Memo")
        assetDao.insertAsset(asset)

        val retrievedAsset = assetDao.getAssetById("1")
        assertEquals(asset, retrievedAsset)
    }

    @Test
    fun deleteAsset() = runBlocking {
        val asset = AssetEntity("1", "Samsung", 50000, AssetType.STOCK, System.currentTimeMillis(), "Memo")
        assetDao.insertAsset(asset)
        assetDao.deleteAsset("1")

        val retrievedAsset = assetDao.getAssetById("1")
        assertNull(retrievedAsset)
    }
}
