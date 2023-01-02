package com.thiagoperea.pokedexppcompose.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.thiagoperea.pokedexppcompose.data.model.PokeData

class PokeRepository : PagingSource<Int, PokeData>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, PokeData> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = backend.searchUsers(query, nextPageNumber)

            return LoadResult.Page(
                data = response.users,
                prevKey = null, // Only paging forward.
                nextKey = response.nextPageNumber
            )
        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).

            return LoadResult.Error(UnsupportedOperationException())
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PokeData>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }    }

}