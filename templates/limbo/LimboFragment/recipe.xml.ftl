<?xml version="1.0"?>

<#import "root://activities/common/kotlin_macros.ftl" as kt>

<recipe>

    <!-- region Fragment -->

    <instantiate 
        from="root/src/app_package/LimboFragment.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${fragmentClassName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${fragmentClassName}.kt" />

    <!-- endregion -->

    <!-- region View-Model -->

    <instantiate 
        from="root/src/app_package/LimboViewModel.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${viewModelClassName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${viewModelClassName}.kt" />

    <!-- endregion -->

    <!-- region Trait -->

    <#if includeTrait>

        <instantiate
            from="root/src/app_package/LimboTrait.kt.ftl"
            to="${escapeXmlAttribute(srcOut)}/${traitClassName}.kt" />

        <open file="${escapeXmlAttribute(srcOut)}/${traitClassName}.kt" />

    </#if>

    <!-- endregion -->

    <!-- region Dagger's Module -->

    <#if includeDaggerModule>

	      <instantiate
            from="root/src/app_package/LimboModule.kt.ftl"
            to="${escapeXmlAttribute(srcOut)}/${moduleClassName}.kt" />

        <open file="${escapeXmlAttribute(srcOut)}/${moduleClassName}.kt" />

    </#if>

    <!-- endregion -->

    <!-- region Layout -->

    <#if includeLayout>
        
        <instantiate 
            from="root/res/layout/fragment_limbo.xml.ftl"
            to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />

        <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />

    </#if>

    <!-- endregion -->

</recipe>
