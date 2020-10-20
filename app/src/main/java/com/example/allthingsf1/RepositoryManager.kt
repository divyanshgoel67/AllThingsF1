package com.example.allthingsf1

class RepositoryManager {

    private lateinit var repositoryComponent: RepositoryComponent
    private lateinit var staticRepositoryComponent : StaticRepositoryComponent

    companion object {

        @JvmStatic
        lateinit var instance : RepositoryManager

        @JvmStatic
        fun initialise() {
            instance = RepositoryManager()
            instance.initialiseStaticRepositoryComponent()
        }
    }

    fun updateRepositoryComponent(repositoryComponent: RepositoryComponent) {
        this.repositoryComponent = repositoryComponent
    }

    fun getRepositoryComponent() : RepositoryComponent {
        return this.repositoryComponent
    }


    fun initialiseStaticRepositoryComponent() {
        this.staticRepositoryComponent = DaggerStaticRepositoryComponent.create()
    }

    fun getStaticRepositoryComponent() : StaticRepositoryComponent {
        return this.staticRepositoryComponent
    }

}
