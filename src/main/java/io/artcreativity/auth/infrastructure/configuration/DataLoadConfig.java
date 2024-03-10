package io.artcreativity.auth.infrastructure.configuration;

import io.artcreativity.auth.domain.model.entities.TypePrivilege;
import io.artcreativity.auth.domain.model.entities.TypeRole;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaPrivilege;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaRole;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaPrivilegeRepository;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaRoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataLoadConfig {
    private final JpaRoleRepository jpaRoleRepository;
    private final JpaPrivilegeRepository jpaPrivilegeRepository;

    @PostConstruct
    public void loadRole() {
        if (jpaPrivilegeRepository.count() > 0)
            return;

        List<JpaPrivilege> privilegeAdmin = new ArrayList<>();
        List<JpaPrivilege> privilegeUser = new ArrayList<>();
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Créer un utilisateur", TypePrivilege.CREATE_ADMIN_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Voir les utilisateurs", TypePrivilege.READ_ADMIN_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Voir le profil d'un utilisateur", TypePrivilege.SHOW_ADMIN_DETAIL_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Modifier un utilisateur", TypePrivilege.UPDATE_ADMIN_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Changer le mot de passe d'un utilisateur", TypePrivilege.CHANGE_ADMIN_PASSWORD_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Suspendre un utilisateur", TypePrivilege.SUSPEND_ADMIN_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des utilisateurs", "Supprimer un utilisateur", TypePrivilege.DELETE_ADMIN_USER));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des roles", "Créer un role", TypePrivilege.CREATE_ADMIN_ROLE));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des roles", "Voir les roles", TypePrivilege.READ_ADMIN_ROLE));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des roles", "Modifier un role", TypePrivilege.UPDATE_ADMIN_ROLE));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Gestion des roles", "Supprimer un role", TypePrivilege.DELETE_ADMIN_ROLE));
        privilegeAdmin.add(createPrivilege(TypeRole.ROLE_ADMIN, "Statistiques", "Consulter les statistiques globales", TypePrivilege.SHOW_GLOBAL_STAT));


        privilegeUser.add(createPrivilege(TypeRole.ROLE_SIMPLE, "Simple Utilisateur", "Simple Utilisateur", TypePrivilege.SIMPLE_USER));
        privilegeUser.add(createPrivilege(TypeRole.ROLE_SIMPLE, "Simple Utilisateur", "Créer une entreprise", TypePrivilege.CREATE_COMPANY));
        privilegeUser.add(createPrivilege(TypeRole.ROLE_SIMPLE, "Simple Utilisateur", "Lire les entreprises", TypePrivilege.READ_COMPANY));
        privilegeUser.add(createPrivilege(TypeRole.ROLE_SIMPLE, "Simple Utilisateur", "Changer son mot de passe", TypePrivilege.CHANGE_OWN_PASSWORD));


        createPrivilege(TypeRole.ROLE_COMPANY, "Tableau de Bord", "Accéder au tableau de bord", TypePrivilege.ACCESS_TO_DASHBOARD);
        createPrivilege(TypeRole.ROLE_COMPANY, "Entreprise", "Mettre à jour les informations de l'entreprise", TypePrivilege.UPDATE_COMPANY);
        createPrivilege(TypeRole.ROLE_COMPANY, "Entreprise", "Supprimer l'entreprise", TypePrivilege.DELETE_COMPANY);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Créer un utilisateur", TypePrivilege.CREATE_USER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Voir les utilisateurs", TypePrivilege.READ_USER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Voir le profil d'un utilisateur", TypePrivilege.SHOW_DETAIL_USER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Modifier un utilisateur", TypePrivilege.UPDATE_USER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Changer le mot de passe d'un utilisateur", TypePrivilege.CHANGE_PASSWORD_USER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Suspendre un utilisateur", TypePrivilege.SUSPEND_USER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des utilisateurs", "Supprimer un utilisateur", TypePrivilege.DELETE_USER);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des roles", "Créer un role", TypePrivilege.CREATE_ROLE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des roles", "Créer et modifier un role", TypePrivilege.CREATE_UPDATE_ROLE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des roles", "Voir les roles", TypePrivilege.READ_ROLE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des roles", "Modifier un role", TypePrivilege.UPDATE_ROLE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des roles", "Supprimer un role", TypePrivilege.DELETE_ROLE);

        createPrivilege(TypeRole.ROLE_COMPANY, "Statistiques", "Voir le bilan des ventes", TypePrivilege.CAN_SEE_SALE_BALANCE_SHEET);
        createPrivilege(TypeRole.ROLE_COMPANY, "Statistiques", "Voir le bilan des produits", TypePrivilege.CAN_SEE_PRODUCT_BALANCE_SHEET);
        createPrivilege(TypeRole.ROLE_COMPANY, "Statistiques", "Voir le statistique des utilisateurs", TypePrivilege.CAN_SEE_USER_BALANCE_SHEET);

//		createPrivilege(TypeRole.ROLE_COMPANY, "Cusinier", "cusinier", TypePrivilege.COOKER));
//		createPrivilege(TypeRole.ROLE_COMPANY, "Retour d'informations", "Voir un retour d'information", TypePrivilege.CAN_SEE_FEEDBACK));

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Créer et modifier une commande", TypePrivilege.CREATE_UPDATE_ORDER_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Supprimer une commande", TypePrivilege.DELETE_ORDER_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Voir les commandes", TypePrivilege.READ_ORDER_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Accepter une commande", TypePrivilege.ACCEPT_ORDER_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Passer une commande", TypePrivilege.SEND_ORDER_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Gérer une commande", TypePrivilege.MANAGE_ORDER_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Faire une remise", TypePrivilege.CAN_DO_DISCOUNT_INVOICE_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion Commerciale", "Voir factures", TypePrivilege.CAN_SEE_INVOICE_BUSINESS);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la caisse", "Générer une facture", TypePrivilege.GENERATE_INVOICE_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la caisse", "Modifier une facture", TypePrivilege.UPDATE_INVOICE_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la caisse", "Imprimer une facture", TypePrivilege.PRINT_INVOICE_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la caisse", "Voir la liste des factures", TypePrivilege.READ_INVOICE_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la caisse", "Gérer les factures", TypePrivilege.MANAGE_INVOICE_SERVICE);

        createPrivilege(TypeRole.ROLE_COMPANY, "Configuration", "Gérer entreprise", TypePrivilege.MANAGE_CONFIGURATION);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des clients", "Créer et modifier un client", TypePrivilege.CREATE_UPDATE_CUSTOMER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des clients", "Supprimer un client", TypePrivilege.DELETE_CUSTOMER);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des clients", "Voir la liste des clients", TypePrivilege.READ_CUSTOMER);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des produits", "Créer et modifier un produit", TypePrivilege.CREATE_UPDATE_PRODUCT);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des produits", "Voir la liste des produits", TypePrivilege.READ_PRODUCT);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des produits", "Supprimer un produit", TypePrivilege.DELETE_PRODUCT);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des services", "Créer et modifier un service", TypePrivilege.CREATE_UPDATE_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des services", "Voir la liste des service", TypePrivilege.READ_SERVICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des services", "Supprimer un service", TypePrivilege.DELETE_SERVICE);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des stocks", "Gérer les stocks d'un service", TypePrivilege.MANAGE_SERVICE_ORDER);

        createPrivilege(TypeRole.ROLE_COMPANY, "Personnel de livraison", "Effectuer une livraison", TypePrivilege.DELIVERY_SLIP_STAFF);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des magaziniers", "Autoriser la sortie des produits", TypePrivilege.IS_WARE_HOUSE_MAN_SERVICE);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des activités de transformation", "Créer une activité", TypePrivilege.CREATE_ACTIVITY);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des activités de transformation", "Gérer une activité et créer des taches", TypePrivilege.MANAGER_ACTIVITY);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des activités de transformation", "Créer et modifier le prix d'une tache de transformation", TypePrivilege.CREATE_UPDATE_TASK_ACTIVITY_PRICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des activités de transformation", "Supprimer le prix d'une tache de transformation", TypePrivilege.DELETE_TASK_ACTIVITY_PRICE);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion des activités de transformation", "Voir la liste des prix des taches de transformation", TypePrivilege.READ_TASK_ACTIVITY_PRICE);

        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la comptabilité", "Faire une saisie comptable", TypePrivilege.MAKE_ACCOUNTING_ENTRY);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la comptabilité", "Faire une imputation", TypePrivilege.MAKE_IMPUTATION);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la comptabilité", "Générer le grand livre", TypePrivilege.GENERATE_GRAND_BOOK);
        createPrivilege(TypeRole.ROLE_COMPANY, "Gestion de la comptabilité", "Définir et modifier un compte", TypePrivilege.DEFINE_UPADATE_ACCOUNT);

        createPrivilege(TypeRole.ROLE_COMPANY, "Ressources humaines", "Gestions des employés et du personnel", TypePrivilege.HUMANS_RESOURCE);

        JpaRole roleAdmin = new JpaRole("Super Admin", TypeRole.ROLE_ADMIN);
        roleAdmin.setPrivileges(Set.copyOf(privilegeAdmin));
        jpaRoleRepository.save(roleAdmin);

        JpaRole roleUser = new JpaRole("Simple User", TypeRole.ROLE_SIMPLE);
        roleUser.setPrivileges(Set.copyOf(privilegeUser));
        jpaRoleRepository.save(roleUser);

    }

    private JpaPrivilege createPrivilege(TypeRole typeRole, String category, String description, TypePrivilege typePrivilege) {
        return jpaPrivilegeRepository.save(new JpaPrivilege(category, typePrivilege, description, typeRole));
    }
}
