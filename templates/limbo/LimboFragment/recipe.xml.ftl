<?xml version="1.0"?>

<#import "root://activities/common/kotlin_macros.ftl" as kt>

<recipe>

    <!-- region Dependencies -->

    <@kt.addAllKotlinDependencies />

    <!-- endregion -->

    <!-- region Fragment -->

    <instantiate 
        from="root/src/app_package/LimboFragment.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${fragmentClassName}.kt" />

    <!-- endregion -->

    <!-- region View-Model -->

    <instantiate 
        from="root/src/app_package/LimboViewModel.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${viewModelClassName}.kt" />

    <!-- endregion -->

    <!-- region Trait -->

    <instantiate 
        from="root/src/app_package/LimboTrait.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${traitClassName}.kt" />
				   
    <!-- endregion -->

    <!-- region Dagger's Module -->

	<instantiate 
        from="root/src/app_package/LimboModule.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${moduleClassName}.kt" />
				  
    <!-- endregion -->

    <!-- region Layout -->

    <#if includeLayout>
        
        <instantiate 
            from="root/res/layout/fragment_limbo.xml.ftl"
            to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />

        <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />

    </#if>

    <!-- endregion -->

    <!-- region Post Action -->

    <open file="${escapeXmlAttribute(srcOut)}/${fragmentClassName}.kt" />

    <!-- endregion -->

</recipe>
