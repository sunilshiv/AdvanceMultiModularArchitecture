package flavours

import build.BuildDimensions
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.internal.AbstractNamedDomainObjectContainer

sealed class BuildFlavour(val name : String) {
    //its for app
    abstract fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>) : ApplicationProductFlavor

    //its for modules
    abstract fun createLibrary(namedDomainObjectContainer: AbstractNamedDomainObjectContainer<LibraryProductFlavor>) : LibraryProductFlavor

    object Google : BuildFlavour(FlavourTypes.GOOGLE) {

        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
           return namedDomainObjectContainer.create(name){
               dimension = BuildDimensions.STORE
               applicationIdSuffix = ".$name"
               versionNameSuffix = "-$name"
           }
        }

        override fun createLibrary(namedDomainObjectContainer: AbstractNamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
            }
        }
    }

    object Huawei : BuildFlavour(FlavourTypes.HUAWEI){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDimensions.STORE
                applicationIdSuffix = ".$name"
                versionNameSuffix = "-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: AbstractNamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
            }
        }
    }

    object Driver : BuildFlavour(FlavourTypes.DRIVER){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDimensions.APP
                applicationIdSuffix = ".$name"
                versionNameSuffix = "-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: AbstractNamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDimensions.APP
            }
        }
    }

    object Client : BuildFlavour(FlavourTypes.CLIENT){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
                applicationIdSuffix = ".$name"
                versionNameSuffix = "-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: AbstractNamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDimensions.APP
            }
        }
    }

}